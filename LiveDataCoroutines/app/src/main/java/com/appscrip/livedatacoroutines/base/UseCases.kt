package com.appscrip.livedatacoroutines.base

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.livedatacoroutines.usecases.coroutines.usecase1.SingleNetworkRequestActivity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UseCase(
	val description: String,
	val targetActivity: Class<out AppCompatActivity>
) : Parcelable

@Parcelize
data class UseCaseCategory(val categoryName: String, val useCases: List<UseCase>) : Parcelable
const val useCaseDescription1 = "Single Network API call"
private val coroutinesUseCaseList =
	UseCaseCategory(
		"Coroutines use cases ", listOf(
			UseCase(
				useCaseDescription1,
				SingleNetworkRequestActivity::class.java)
	)
)
val useCaseCategories = listOf(
	coroutinesUseCaseList
)
