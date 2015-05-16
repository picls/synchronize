'''
Created on 2015-5-8

@author: anzhixiang
'''

import requests
import re
import os
import sys
import datetime
import bs4
from bs4 import BeautifulSoup


headers = {'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
           'Accept-Encoding': 'gzip, deflate, compress',
           'Accept-Language': 'en-us;q=0.5,en;q=0.3',
           'Cache-Control': 'max-age=0',
           'Connection': 'keep-alive',
        
           'X-Requested-With': 'XMLHttpRequest',
           'User-Agent': 'Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36' }

url = "http://ddclick.dangdang.com/recommend_kpi.php?m=productview&&visit=0&index=0&date=2015-05-07"
bbocont = requests.get(url,headers=headers).content.decode('utf-8')
print(bbocont)