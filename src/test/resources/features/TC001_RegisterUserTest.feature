Feature:Selendroid apk test senaryosu
@selendroid
  Scenario Outline: Kullanici selendroid mobil application da kayit olabilmeli

    Given Kullanici selendroid mobil applikasyonu uyari yazisini kabul eder
    And Kullanici start user registration butonunu tiklar
    And Kullanici username olarak "<username>" girer
    And Kullanici email olarak "<email>" girer
    And Kullanici password plarak "<password>" girer
    And Kullanici name olarak "<name>" girer
    And Kullanici programming language olarak "<programming language>" girer
    And Kullanici accept adds butonu secer ve register butonuna basar
    Then Kullanici girdigi bilgilerin dogru oldugunu teyit eder
    Then Kullanici register user butonuna basar


    Examples:
      | username | email | password | name | programming language |
      |ferhat123 |ferhat@hotmail.com|12345|ferhat|Java            |