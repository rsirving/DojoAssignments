import requests as r
def basic_info(url):
    info = r.get(url)
    print info.json

basic_info('https://github.com/timeline.json')