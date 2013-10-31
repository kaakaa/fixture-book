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
package com.xpfriend.junk;

import com.xpfriend.junk.temp.TextConverter;

/**
 * 文字列とオブジェクトのコンバータ。
 * 
 * @author Ototadana
 */
public final class Convi {
	
	private static TextConverter instance = TextConverter.getInstance();

	static {
		new Convi(); // for coverage
	}
	
	private Convi() {
	}
	
	/**
	 * オブジェクトを文字列に変換する。
	 * @param object 変換元オブジェクト。
	 * @return 変換された文字列。null は "" に変換して返される。
	 */
	public static String toString(Object object) {
		return instance.toString(object);
	}
}
