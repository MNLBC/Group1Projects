import json
info = {'name': 'jay', 'sex': 'male'}
jsoninfo = json.dumps(info)
print(jsoninfo)
print(type(jsoninfo))

a = '{"isOK":1 ,"isRunning": "None"}'
b = json.loads(a)
print(b['isOK'])