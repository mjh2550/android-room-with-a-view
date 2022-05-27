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

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 1열 데이터베이스 테이블의 행인 엔터티를 나타내는 기본 클래스입니다.
 *
 * @ Entity - 클래스 이름이 아닌 경우 클래스에 엔티티로 주석을 달고 테이블 이름을 제공해야 합니다.
 * @ PrimaryKey - 기본 키를 식별해야 합니다.
 * @ ColumnInfo - 변수명과 다른 경우 컬럼명을 입력해야 합니다.
 *
 * 주석 세트에 대한 설명서를 참조하십시오.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
