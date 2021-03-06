﻿
### FixtureBook チュートリアル (Spock編)

#03 データ取得メソッド getAllEmployees のテスト
===============================================

テスト対象のメソッド
--------------------

ここでは、以下の getAllEmployees メソッドを対象にテストを行います。

```java
    List<Employee> getAllEmployees() {
        def sql = createSql()
        def employees = []
        sql.eachRow("SELECT * FROM EMPLOYEE") {
            def employee = new Employee(
                id:it.ID, name:it.NAME, age:it.AGE, retire:it.RETIRE, 
                lastUpdated:it.LAST_UPDATED.timestampValue())
            employees.add(employee)
        }
        return employees
    }
```

getAllEmployees メソッドは、EMPLOYEE テーブル上にある全てのデータをリスト (List<Employee>) として取得します。


テストケース
------------

以下のテストケースをテストします。

*   <b>データベーステーブル (EMPLOYEE) 上の全データが取得できる</b>


FixtureBook の記述
------------------

FixtureBook では以下の記述を行います。

*   `B.テストデータクリア条件` で `*` を指定して、一旦全データを消去する。
*   getAllEmployees でデータ取得できるようにするために、`B.テストデータ` に何件かデータを記述する。
*   getAllEmployees で取得できるはずのデータを予想結果として `E.取得データ` に記述する。


![FixtureBook記述](./images/Tutorial-getAllEmployees-01.png?raw=true)


テストメソッドの記述
--------------------

次に単体テストクラスにテストメソッドを追加します。

メソッドの記述内容は以下のようになります。

1.  `fixtureBook.setup()` を呼び出し、`B.テストデータクリア条件` でのデータ削除と
    `B.テストデータ` のデータ投入を行う。
2.  テスト対象メソッド `getAllEmployees()` を呼び出して、戻り値 (`List<Employee> employees`) を取得する。
3.  `fixtureBook.validate(employees)` を呼び出し、戻り値 employees の内容が正しいかどうかをチェックする。

&nbsp;

    def "getAllEmployees__データベーステーブルEMPLOYEE上の全データが取得できる"() {
        setup:
        fixtureBook.setup()
        
        when:
        List<Employee> employees = new EmployeeStore().getAllEmployees()
        
        then:
        fixtureBook.validate(employees, "Employee")
    }


ここでは、`fixtureBook.validate(employees, "Employee")` というふうに、
`E.取得データ` の中の "Employee" という名前のテーブル定義と比較チェックすることを明示的に指定していますが、
今回のように `E.取得データ` にひとつしかテーブル定義がない場合は、
`fixtureBook.validate(employees)` というふうに "Employee" を省略することが可能です。


------------------------

*   [FixtureBook チュートリアル (Spock編)](./Tutorial-Spock.md)
    *   [#01 データ登録メソッド save のテスト](./Tutorial-Spock-save.md)
    *   [#02 データ削除メソッド delete のテスト](./Tutorial-Spock-delete.md)
    *   #03 データ取得メソッド getAllEmployees のテスト
    *   [#04 データ検索メソッド getEmployees のテスト](./Tutorial-Spock-getEmployees.md)
    *   [#05 例外発生のテスト](./Tutorial-Spock-Exception.md)
    *   [#06 テストメソッドの簡略化](./Tutorial-Spock-expect.md)
