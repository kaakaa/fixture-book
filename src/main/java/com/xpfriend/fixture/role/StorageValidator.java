/*
 * Copyright 2013 XPFriend Community.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xpfriend.fixture.role;

/**
 * テスト対象メソッド呼び出し後のストレージ状態を検証するためのアクター。
 * 
 * @author Ototadana
 */
public interface StorageValidator extends Actor {

	/**
	 * 現在のストレージ状態が予想結果と適合するかどうかを調べる。
	 * 予想結果と適合しない場合は {@link AssertionError} がスローされる。
	 * 
	 * @exception AssertionError 予想結果と適合しない場合。
	 */
	void validate();

	/**
	 * このアクターに役割があるかどうかを調べる。
	 * 
	 * @return 役割がある場合は true。
	 */
	boolean hasRole();
}
