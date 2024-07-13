package com.example.gangapackagesolution.repository

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.FileProvider
import com.example.gangapackagesolution.constants.Constants
import com.example.gangapackagesolution.models.DataOrException
import com.example.gangapackagesolution.models.Quotation.Quotation
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object Repository {


    // Suspend function to get OTP
    suspend fun getOtp(
        phone: String,
        otpRequestState: MutableStateFlow<DataOrException<String, Exception>>
    ) {
        val client = OkHttpClient()

        val requestBody = "+91$phone".toRequestBody("text/plain".toMediaTypeOrNull())

        val request = Request.Builder()
            .url("${Constants.baseUrl}OtpRequest")
            .post(requestBody)
            .build()

        // Set loading to true before starting the request
        otpRequestState.value = DataOrException(loading = true)

        try {
            val response = withContext(Dispatchers.IO) {
                client.newCall(request).execute()
            }

            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                if (responseBody != null) {
                    otpRequestState.value = DataOrException(data = responseBody, loading = false)
                } else {
                    otpRequestState.value =
                        DataOrException(e = IOException("Empty response body"), loading = false)
                }
            } else {
                otpRequestState.value = DataOrException(
                    e = IOException("Unsuccessful response: ${response.message}"),
                    loading = false
                )
            }
        } catch (e: Exception) {
            otpRequestState.value = DataOrException(e = e, loading = false)
        }
    }


    // verify otp
    suspend fun verifyOtp(
        phone: String,
        otp: String,
        otpVerifyState: MutableStateFlow<DataOrException<String, Exception>>
    ) {

        val client = OkHttpClient()
        val json = """
            {
                "mobile": "+91$phone",
                "otp": "$otp"
            }
        """.trimIndent()

        val requestBody = json.toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url("${Constants.baseUrl}OtpVerify")
            .post(requestBody)
            .build()

        try {
            otpVerifyState.value = DataOrException(loading = true)
            val response = withContext(Dispatchers.IO)
            {
                client.newCall(request).execute()
            }
            if (response.isSuccessful) {
                val responseBody = response.body?.string()



                if (responseBody != null) {
                    if (responseBody.contains("Not Verified")) {
                        otpVerifyState.value =
                            DataOrException(e = IOException("Not Verified"), loading = false)
                    } else {
                        otpVerifyState.value = DataOrException(data = responseBody, loading = false)
                    }

                } else {
                    otpVerifyState.value =
                        DataOrException(e = IOException("Empty response body"), loading = false)
                }
            }


        } catch (e: Exception) {
            otpVerifyState.value = DataOrException(e = e, loading = false)
        }
    }

    // verify if user is new
    suspend fun verifyUserIsNew(
        mobile: String, otpVerifyState: MutableStateFlow<DataOrException<Boolean, Exception>>
    ) {

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("${Constants.baseUrl}isNewUser/$mobile")
            .get()
            .build()

        try {
            otpVerifyState.value = DataOrException(loading = true)
            val response = withContext(Dispatchers.IO)
            {
                client.newCall(request).execute()
            }
            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                if (responseBody != null) {
                    if (responseBody == "true") {
                        otpVerifyState.value = DataOrException(data = true, loading = false)
                    } else {
                        otpVerifyState.value = DataOrException(data = false, loading = false)
                    }

                }


            }


        } catch (e: Exception) {
            otpVerifyState.value =
                DataOrException(e = IOException("Something went wrong"), loading = false)
        }


    }

    // get the quotation form
    suspend fun getTheQuotationForm(quotationState: MutableStateFlow<DataOrException<Quotation, Exception>>) {
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("${Constants.baseUrl}getQuotationForm/${getJwt()}")
                .build()

            try {
                quotationState.value = DataOrException(loading = true)
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    response.body?.use { responseBody ->
                        val quotation =
                            Gson().fromJson(responseBody.string(), Quotation::class.java)
                        quotationState.value = DataOrException(data = quotation, loading = false)


                    } ?: run {

                        quotationState.value =
                            DataOrException(e = IOException("Empty response body"), loading = false)
                    }
                } else {

                    quotationState.value =
                        DataOrException(e = IOException("Something went wrong"), loading = false)
                }
            } catch (e: Exception) {

                quotationState.value = DataOrException(e = e, loading = false)
            }
        }
    }

    suspend fun gettingListOfQuotation(

        quotationState: MutableStateFlow<DataOrException<List<Quotation>, Exception>>
    ) {
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("${Constants.baseUrl}quotationList/${getJwt()}")
                .build()

            try {
                quotationState.value = DataOrException(loading = true)
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    response.body?.use { responseBody ->
                        val quotation =
                            Gson().fromJson(responseBody.string(), Array<Quotation>::class.java)
                                .toList()
                        quotationState.value = DataOrException(data = quotation, loading = false)
                    }
                        ?: run {
                            quotationState.value =
                                DataOrException(
                                    e = IOException("Empty response body"),
                                    loading = false
                                )
                        }

                }
            } catch (e: Exception) {
                quotationState.value = DataOrException(e = e, loading = false)
            }
        }
    }


    // save edited
    suspend fun saveEdited(
        quotation: Quotation,
        quotationState: MutableStateFlow<DataOrException<List<Quotation>, Exception>>,
        refresh: () -> Unit
    ) {
        withContext(Dispatchers.IO) {

            val json = Gson().toJson(quotation)
            val requestBody = json.toRequestBody("application/json".toMediaTypeOrNull())
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("${Constants.baseUrl}saveEditedQuotation/${quotation.id}/${getJwt()}")
                .post(requestBody)
                .build()

            try {

                quotationState.value = DataOrException(loading = true)
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    Log.d("djxd", "dnxdxndjxn")
                    response.body?.use { responseBody ->
                        refresh()
                    }

                } else {
                    Log.d("djxd", "dnxdxndjxn")
                    quotationState.value =
                        DataOrException(e = IOException("Something went wrong"), loading = false)
                }

            } catch (e: Exception) {
                Log.d("jednejnedjejnw", "$e")
            }

        }
    }

    // saving normal Quotation
    suspend fun saveQuotation(
        quotation: Quotation,
        quotationState: MutableStateFlow<DataOrException<String, Exception>>,
        refresh: () -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val json = Gson().toJson(quotation)
            val requestBody = json.toRequestBody("application/json".toMediaTypeOrNull())
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("${Constants.baseUrl}saveQuotation/${getJwt()}")
                .post(requestBody)
                .build()

            try {
                quotationState.value = DataOrException(loading = true)
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {

                    withContext(Dispatchers.Main) {
                        refresh()
                    }
                }


            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    Log.e("saveQuotation", "Network error: ${e.message}", e)
                    quotationState.value = DataOrException(e = e, loading = false)
                }
            } catch (e: Exception) {
                quotationState.value = DataOrException(e = e, loading = false)
            }
        }


    }

    // downloading the Quotation Pdf

    suspend fun downloadPdf(
        context: Context,
        id: String,
        pdfState: MutableStateFlow<DataOrException<String, Exception>>,
        share: Boolean
    ) {
        pdfState.value = DataOrException(loading = true)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("${Constants.baseUrl}download/$id/${getJwt()}")
            .get()
            .build()

        try {
            withContext(Dispatchers.IO) {
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    response.body?.let { responseBody ->
                        val pdfBytes = responseBody.bytes()
                        val file = File(context.cacheDir, "Quotation$id.pdf")

                        FileOutputStream(file).use { fos ->
                            fos.write(pdfBytes)
                        }
                        val uri = FileProvider.getUriForFile(
                            context,
                            "${context.packageName}.provider",
                            file
                        )
                        if (!share) {
                            // View the PDF

                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                setDataAndType(uri, "application/pdf")
                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            context.startActivity(intent)
                            pdfState.value =
                                DataOrException(data = "Download Successful", loading = false)
                        } else {


                            // Share the PDF
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "application/pdf"
                                putExtra(Intent.EXTRA_STREAM, uri)
                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            val shareIntent = Intent.createChooser(intent, "Share Quotation")
                            context.startActivity(shareIntent)
                            pdfState.value =
                                DataOrException(data = "Share Successful", loading = false)

                        }
                    }

                        ?: throw IOException("Response body is null")
                } else {
                    pdfState.value = DataOrException(
                        e = IOException("Server responded with error: ${response.code}"),
                        loading = false
                    )
                }
            }
        } catch (e: IOException) {
            pdfState.value = DataOrException(e = e, loading = false)
        } catch (e: Exception) {
            pdfState.value = DataOrException(e = e, loading = false)
        }
    }

    // delete quotation
    suspend fun deleteQuotation(
        id: String,
        refresh: () -> Unit
    ) {

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("${Constants.baseUrl}deleteQuote/$id/${getJwt()}")
            .get()
            .build()

        try {

            withContext(Dispatchers.IO) {
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        refresh()
                    }
                } else {
                    Log.d("success", "Deleted")
                }


            }
        } catch (e: Exception) {
            Log.d("djxd", "dnxdxndjxn")
        }
    }


    fun getJwt(): String {
        return "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIrOTE3MDE1OTMyMjI5In0.W4waiHkFPZDZnbbiNyFdgF4HhKuirpgDPg6Y0sLdRIk"
    }
}







