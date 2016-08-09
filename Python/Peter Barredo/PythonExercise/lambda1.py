def increment(n):
	return lambda x: x + n

g = increment(10)
f = increment(20)

print(g(1))
print(f(1))