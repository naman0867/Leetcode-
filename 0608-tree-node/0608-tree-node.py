import pandas as pd

def tree_node(tree: pd.DataFrame) -> pd.DataFrame:
    parents = set(tree['p_id'].dropna())

    def classify(row):
        if pd.isna(row['p_id']):
            return 'Root'
        return 'Inner' if row['id'] in parents else 'Leaf'

    tree['type'] = tree.apply(classify, axis=1)
    return tree[['id', 'type']]