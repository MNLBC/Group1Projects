def read_data(filename):
	fh = None
	movie_list = []
	try:
		fh = open(filename, encoding="utf8")
		for n , line in enumerate(fh):
			line = line.rstrip()
			print("Readline ", n)
			movie_list.append(line)
			print(line)
			
		return True
	except (EnvironmentError, ValueError, KeyError, UnicodeEncodeError, UnicodeDecodeError) as err:
		print(err)
		return False
	finally:
		if fh is not None:
			fh.close()

read_data("writetest.txt")			