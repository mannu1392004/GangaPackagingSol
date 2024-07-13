package com.example.gangapackagesolution.Screens

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gangapackagesolution.models.DataOrException
import com.example.gangapackagesolution.models.Quotation.Quotation
import com.example.gangapackagesolution.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // getting the Quotation pdf from the server
    private val _pdf = MutableStateFlow<DataOrException<String, Exception>>(DataOrException())
    val pdf: StateFlow<DataOrException<String, Exception>> = _pdf


    private val _quotation =
        MutableStateFlow<DataOrException<Quotation, Exception>>(DataOrException())
    val quotation: StateFlow<DataOrException<Quotation, Exception>> = _quotation


    private var _quotationForEdit: Quotation? = null
    val quotationForEdit: Quotation?
        get() = _quotationForEdit


    private val _allQuotation =
        MutableStateFlow<DataOrException<List<Quotation>, Exception>>(DataOrException())
    val allQuotation: StateFlow<DataOrException<List<Quotation>, Exception>> = _allQuotation


    // saveNewQuotation
    private val _quotaionSaveState =
        MutableStateFlow<DataOrException<String, Exception>>(DataOrException())
    val quotaionSaveState: StateFlow<DataOrException<String, Exception>> = _quotaionSaveState


    fun saveNewQuotation(quotation: Quotation, onComplete: () -> Unit) {
        viewModelScope.launch {
            Repository.saveQuotation(
                quotation,
                _quotaionSaveState
            ) {

                onComplete()
            }

        }
    }


    fun getQuotation() {
        viewModelScope.launch {
            Repository.getTheQuotationForm(_quotation)
        }
    }

    fun refreshTheQuotationPage() {
        _quotation.value = DataOrException()
        getAllQuotationList()
    }

    fun resetError() {
        _quotation.value = DataOrException(null, false, null)
        _allQuotation.value = DataOrException(null, false, null)
        _quotaionSaveState.value = DataOrException(null, false, null)
        _quotationForEdit = null
    }


    fun getAllQuotationList() {
        viewModelScope.launch {
            Repository.gettingListOfQuotation(_allQuotation)
        }
    }

    fun saveEditedQuotation(quotation: Quotation) {
        viewModelScope.launch {
            Repository.saveEdited(quotation, _allQuotation) {
                refreshTheQuotationPage()
            }
        }
    }


    fun setQuotationForEdit(quotation: Quotation) {
        _quotationForEdit = quotation
    }


    fun getPdf(id: String, context: Context,share:Boolean) {
        viewModelScope.launch {
            Repository.downloadPdf(
                id = id,
                context = context,
                pdfState = _pdf,
                share = share
            )
        }
    }

    // delete the quotation
    fun deleteQuotation(id: String) {
        viewModelScope.launch {
            Repository.deleteQuotation(id){
                refreshTheQuotationPage()
            }
        }
    }

}
