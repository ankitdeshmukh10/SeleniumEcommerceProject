# SeleniumEcommerceProject

This repository is an implementation of Ecommerce Project(Selenium) from Guru99.com.

Link : https://www.guru99.com/live-ecommerce-project.html

A.  src/Main package contains two classes:

    1. BaseTest class : contains driver setup method
    2. TestUtilities class: contains driver methods and common methods for code reusalization. This class extends BaseTest Class.

B.  src/Test package contains test implementation classes.
    Every testcase class extends TestUtilies class for reusing driver and common methods.

C.  Testsuite package contains TestNG.xml file.
D.  TestCases folder contains testcases description. For every testcase separate class is maintained in src/Test package.
