def add(n):
	result = 0
if type(n) != int or n < 0:
	print('the parameter must be a integer no lessthan zero')
elif n == 0:
	print(0)
elif n > 1:
	result = n * add(n-1)
else 
	result = 1
return result

