import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

class ChromeSearch(unittest.TestCase):
    def setUp(self):
        s = Service('/Users/hemanthharshinee/Downloads/chromedriver')
        self.driver = webdriver.Chrome(service=s)
    def test_search_in_python_org(self):
        for i in range(10): #Simulate a DOS attack to run 10 times
            driver = self.driver
            driver.get("http://localhost:8000/jukebox_without_reCAPTCHA.html") #the website to be attacked
            driver.find_element(By.XPATH,'/html/body/form/input[3]').click()
            driver.find_element(By.XPATH,'/html/body/form/h4[2]/input').send_keys("ATTACK")
            driver.find_element(By.XPATH,"/html/body/form/h4[3]/input").submit()
            driver.back()
            i+=1
        print("Simulated DOS attack has been completed...")

    def tearDown(self):
        self.driver.close()
if __name__ == "__main__":
    unittest.main()
