package com.appscrip.livedatacoroutines.usecases.coroutines.usecase1

import com.appscrip.livedatacoroutines.base.mockAndroidVersions
import com.appscrip.livedatacoroutines.mock.NetworkReqApiClient
import com.appscrip.livedatacoroutines.utils.MockNetworkInterceptor
import com.google.gson.Gson

fun mockApi() =
	NetworkReqApiClient().createMockApi(
		MockNetworkInterceptor()
			.mock(
				"http://localhost/recent-android-versions",
				Gson().toJson(mockAndroidVersions),
				200,
				1500
			)
	)
