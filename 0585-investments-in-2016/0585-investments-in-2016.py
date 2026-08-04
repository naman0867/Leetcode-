import pandas as pd

def find_investments(insurance: pd.DataFrame) -> pd.DataFrame:
    shared_tiv = insurance['tiv_2015'].duplicated(keep=False)
    unique_city = ~insurance.duplicated(subset=['lat', 'lon'], keep=False)
    total = insurance.loc[shared_tiv & unique_city, 'tiv_2016'].sum()
    return pd.DataFrame({'tiv_2016': [round(total, 2)]})