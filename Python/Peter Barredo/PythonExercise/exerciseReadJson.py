import json

def readJSON(fileName):
	try:
		
		fp = open(fileName, 'r')
		data = json.loads(fp.read())
		print(data['name'])
		return True

	except (EnvironmentError,ValueError,KeyError,UnicodeEncodeError,UnicodeDecodeError) as err:
		print(err)
		return False
	finally:
		fp.close()

readJSON('data.json')