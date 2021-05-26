package com.gt.domain.usecase

import app.cash.turbine.test
import com.gt.data.datasource.local.socialchannel.SocialChannelLocalDataSource
import com.gt.domain.mock_data.MockUtil
import com.gt.domain.repository.SocialChannelRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@RunWith(MockitoJUnitRunner::class)
internal class SocialChannelUseCaseImplTest {
    private val socialRepo: SocialChannelRepository = mock<SocialChannelRepository>()
    private val socialChannelLocalDataSource: SocialChannelLocalDataSource = mock()
    lateinit var sut: SocialChannelUseCaseImpl

    @Before
    fun setup() {
        sut = SocialChannelUseCaseImpl(socialRepo)
    }

    @ExperimentalTime
    @Test
     fun check_if_free_has_premium_value_set() {
        val mockData = MockUtil.mockSocialList()
        whenever(sut.fetchSocialDataFlow("FREE")).thenReturn(MockUtil.getMockSocialFlow())

        runBlocking {
            val fetchedDataFlow = sut.fetchSocialDataFlow("FREE").test(2.seconds) {
                val item = requireNotNull(expectItem())
                Assert.assertEquals(item.size, mockData.size)
                Assert.assertEquals(item, mockData)
                expectComplete()
            }


            fetchedDataFlow.apply {

            }
        }

    }

}