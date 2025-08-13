import pandas as pd

df = pd.read_csv('/Users/michaelchinkov/Documents/Programing Projects/Python Projects/YobeeProjects/AreaCodeFiltering/Half Home Users Export Jan 27 2025.csv')

phone = df[(df["Phone"])]

