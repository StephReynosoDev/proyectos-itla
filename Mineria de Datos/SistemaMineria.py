from pathlib import Path
import pandas as pd
import matplotlib.pyplot as plt

base = Path(__file__).resolve().parent
ruta = base / "avocado.csv"

zonas = ["Albany", "Chicago", "Houston"]
colores = ["red", "blue", "green"]

def cargar():
    return pd.read_csv(ruta)

def dimensiones(df):
    f, c = df.shape
    print(" Dimensiones del conjunto de datos")
    print(f"El conjunto tiene {f} filas y {c} columnas")
    print()

def primeros(df):
    print(" Primeros 100 registros")
    print(df.head(100).to_string())
    print()

def ultimos(df):
    print(" Ultimos 20 registros")
    print(df.tail(20).to_string())
    print()

def estadisticas(df):
    p = df["AveragePrice"]
    print(" Precio del aguacate")
    print(f"Precio minimo {p.min():.2f}")
    print(f"Precio maximo {p.max():.2f}")
    print(f"Precio promedio {p.mean():.2f}")
    print()

def grafico(df):
    print(" Grafico scatter de year contra AveragePrice")
    fig, ax = plt.subplots(figsize=(10, 5))
    
    for z, c in zip(zonas, colores):
        sub = df[df["region"] == z]
        ax.scatter(sub["year"], sub["AveragePrice"], label=z, color=c, alpha=0.5)

    ax.set_title("Precio promedio del aguacate por anio en tres regiones")
    ax.set_xlabel("year")
    ax.set_ylabel("AveragePrice")
    ax.set_xticks(sorted(df["year"].unique()))
    ax.legend(title="Region")
    plt.show()

def main():
    df = cargar()
    dimensiones(df)
    primeros(df)
    ultimos(df)
    estadisticas(df)
    grafico(df)

if __name__ == "__main__":
    main()