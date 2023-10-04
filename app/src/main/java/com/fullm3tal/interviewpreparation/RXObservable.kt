package com.fullm3tal.interviewpreparation

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

fun main() {
    observableExample()
}

fun singleExample() {
    val s1: Single<String> = Single.just("1")
    val s2: Single<String> = Single.just("2")
    val s3: Single<String> = Single.just("3")

    Single.concat(s1, s2, s3).subscribe({
        println(it)
    }, {

    }, {

    }, CompositeDisposable())
}

fun observableExample() {

    val s1: Observable<String> = Observable.just("1")
    val s2: Observable<String> = Observable.just("2")
    val s3: Observable<String> = Observable.just("3")

    Observable.concat(s1, s2, s3).subscribe({
        println(it)
    }, {
        println("Throwable")
    }, {
        println("Complete")
    }, CompositeDisposable())
}

fun flowableExample() {
    val s1: Flowable<String> = Flowable.just("1")
    val s2: Flowable<String> = Flowable.just("2")
    val s3: Flowable<String> = Flowable.just("3")

    Flowable.concat(s1, s2, s3).subscribe({
        println(it)
    }, {

    }, {

    }, CompositeDisposable())
}

fun completableExample() {
}