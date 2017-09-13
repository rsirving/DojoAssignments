import requests
r = requests.post('http://httpbin.org/post', data = {'key':'value'})
print r
payload = {'key1': 'value1', 'key2': 'value2'}
r = requests.get('http://httpbin.org/get', params=payload)
print(r.url)
# def basic_info(url):
#     print "test"
#     info = r.get(url)
#     print info
#     print info.json

# basic_info('https://www.reddit.com')