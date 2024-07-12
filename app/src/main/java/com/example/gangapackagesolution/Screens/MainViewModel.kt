package com.example.gangapackagesolution.Screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gangapackagesolution.models.DataOrException
import com.example.gangapackagesolution.models.Quotation.Quotation
import com.example.gangapackagesolution.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _quotation =
        MutableStateFlow<DataOrException<Quotation, Exception>>(DataOrException())
    val quotation: StateFlow<DataOrException<Quotation, Exception>> = _quotation

    private var _quotationForEdit: Quotation? = null
    val quotationForEdit: Quotation?
        get() = _quotationForEdit



    private val _allQuotation =
        MutableStateFlow<DataOrException<List<Quotation>, Exception>>(DataOrException())
    val allQuotation: StateFlow<DataOrException<List<Quotation>, Exception>> = _allQuotation
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
    }


    fun getAllQuotationList() {
        viewModelScope.launch {
            Repository.gettingListOfQuotation(_allQuotation)
        }
    }

    fun saveEditedQuotation(quotation: Quotation) {
        viewModelScope.launch {
            Repository.saveEdited(quotation,_allQuotation){
                refreshTheQuotationPage()
            }
        }
    }


    fun setQuotationForEdit(quotation: Quotation){
        _quotationForEdit = quotation
    }

}
