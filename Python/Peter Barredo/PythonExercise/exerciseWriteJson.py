import json

def writeFile(filePath):
	fh = None
	try:
		fh = open(filePath,'w', encoding='utf8')
		data = {'name': 'ACME', 'shares': 100}
		for n in range(10):
			json.dump(data,fh)
		return True	
	except (EnvironmentError,ValueError,KeyError,UnicodeEncodeError,UnicodeDecodeError) as err:
		print(err)
		return False
	finally:
		if fh is not None:
			fh.close()

writeFile('pythonwrite.json')			