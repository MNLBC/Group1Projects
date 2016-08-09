def get_counts(sequence):
	counts = {}
	for x in sequence:
		if x in counts:
			counts[x] += 1
		else:
			counts[x] = 1
	return counts


from collections import defaultdict

def get_counts2(sequence):
	counts = defaultdict(int) 
	for x in sequence:
		counts[x] += 1
	return counts


def top_counts(count_dict, n=10):
	value_key_pairs = [(count, tz) for tz, count in count_dict.items()]
	value_key_pairs.sort()
	return value_key_pairs[-n:]

time_zones = [rec['tz'] for rec in records if 'tz' in rec]


from collections import Counter

counts = Counter(time_zones)
counts.most_common(10)
