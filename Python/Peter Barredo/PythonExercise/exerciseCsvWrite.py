import csv
def writeFile(fileName):
	fh = None
	try:
		with open(fileName,'w') as csvFile:
			writeCSV = csv.writer(csvFile, delimiter=",")
			for n in range(10):
				writeCSV.writerow(['hello','hi','peter'])
			return True
	except (EnvironmentError,ValueError,KeyError,UnicodeEncodeError,UnicodeDecodeError) as err:
		print(err)
		return False
	finally:
		if fh  is not None:
			fh.close()
writeFile('writeCSV.csv')			