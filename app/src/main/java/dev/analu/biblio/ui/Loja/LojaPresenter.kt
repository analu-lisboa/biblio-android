package dev.analu.biblio.ui.Loja

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class LojaPresenter(val view: Mvp.View) : Mvp.Presenter {

    private var disposables = CompositeDisposable()

    private val model: Mvp.Model by lazy<Mvp.Model>{
        LojaModel(this)
    }

    override fun LoadBooks(context: Context){
        
        disposables.add(model.getAllBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> view.showLista(result) },
                { throwable -> view.showError(throwable?.message ?: "") }
            )
        )
    }


}