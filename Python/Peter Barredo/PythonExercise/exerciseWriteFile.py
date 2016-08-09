def write_data(filename):
	fh = None
	movie_list = []
	try:
		fh = open(filename,'w', encoding="utf8")
		for n in range(10):
			fh.write('This is line {0} \n'.format(n))
		return True

	except (EnvironmentError, ValueError, KeyError, UnicodeEncodeError, UnicodeDecodeError) as err:
		print(err)
		return False
	finally:
		if fh is not None:
			fh.close()

write_data('writetest.txt')			