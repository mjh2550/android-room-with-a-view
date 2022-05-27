/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.roomwordssample

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class WordRepository(private val wordDao: WordDao) {

    // Room은 별도의 스레드에서 모든 쿼리를 실행합니다.
    // Observed Flow는 데이터가 변경되면 관찰자에게 알립니다.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    // 기본적으로 Room은 메인 스레드에서 일시 중단 쿼리를 실행하므로 다음을 수행할 필요가 없습니다.
    // 장기 실행 데이터베이스 작업을 하지 않도록 다른 것을 구현합니다.
    // 메인 스레드를 끕니다.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
