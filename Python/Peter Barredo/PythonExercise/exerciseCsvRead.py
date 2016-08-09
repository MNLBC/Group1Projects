import csv



def readFile(fileName):
	fh = None
	try:
		with open(fileName) as csvfile:
			readCSV = csv.reader(csvfile, delimiter=',')
			for row in readCSV:
				print(row)
				print(row[0])
		return True
	except (EnvironmentError,ValueError,KeyError,UnicodeEncodeError,UnicodeDecodeError) as err:
		print(err)
		return False
	finally:
		if fh is not None:
			fh.close()

readFile('pythonCsv.csv')			