import pandas as pd
import matplotlib.pyplot as plt

pd.set_option('display.expand_frame_repr', False)
pd.set_option('display.max_columns', None)
pd.set_option('display.width', 2000)

datos = pd.read_csv("netflix_titles.csv")

print(datos.head(10))

print(datos.tail(15))

print(datos.describe())

datos = datos.fillna(0)
print(datos.isnull().sum())

filtro = datos[(datos["release_year"] >= 2010) & (datos["release_year"] <= 2021)]
tabla = filtro.groupby(["release_year", "type"]).size().unstack()

tabla.columns = ["Movies", "Tv Shows"]

tabla.plot(kind="bar")
plt.xticks(rotation=0)
plt.show()