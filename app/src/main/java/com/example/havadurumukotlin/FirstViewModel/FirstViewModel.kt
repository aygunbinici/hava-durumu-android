package com.example.havadurumukotlin.FirstViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.havadurumukotlin.API.HavaDurumuService
import com.example.havadurumukotlin.model.DataResult
import com.example.havadurumukotlin.model.HavaDurumu
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FirstViewModel: ViewModel() {

    private val countryAPIService = HavaDurumuService()
    private val disposable = CompositeDisposable()

    val canlihaber = MutableLiveData<List<DataResult>> () //Mutable olması değiştirilebilir olması

    fun getDataFromAPI1(verilensehir:String){
              disposable.add(
                countryAPIService.getdata(verilensehir)
                    .subscribeOn(Schedulers.newThread()) //bu arka planda çalışacak
                    .observeOn(AndroidSchedulers.mainThread()) //ana threadde gösterilecek
                    .subscribeWith(object : DisposableSingleObserver<HavaDurumu>() {

                        override fun onSuccess(t: HavaDurumu) {
                            showCountries(t.result)
                            println("Hava" + t.result)

                        }
                        override fun onError(e: Throwable) {

                            e.printStackTrace()
                            println(e.message)
                        }

                    })

            )


    }
    private fun showCountries(haberList: List<DataResult>){
        canlihaber.value= haberList
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }




}