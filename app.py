# app.py
# source .venv/bin/activate
# EXECUTAR:
# streamlit run app.py

import streamlit as st
import pandas as pd
import numpy as np
import plotly.graph_objects as go
import plotly.express as px

# =========================================================
# CONFIG PAGE
# =========================================================
st.set_page_config(
    page_title="Análise de Chefe",
    page_icon="📊",
    layout="wide"
)

# =========================================================
# CSS
# =========================================================
st.markdown("""
<style>

html, body, [class*="css"] {
    font-family: 'Segoe UI', sans-serif;
    background-color: #0a0f2c;
    color: white;
}

.main {
    background:
        radial-gradient(circle at top left, rgba(88,0,255,0.25), transparent 30%),
        radial-gradient(circle at top right, rgba(0,200,255,0.15), transparent 30%),
        #0a0f2c;
}

/* SIDEBAR */
section[data-testid="stSidebar"] {
    background: linear-gradient(180deg,#111633,#090d22);
    border-right: 1px solid rgba(255,255,255,0.05);
}

/* CARDS */
.card {
    background: linear-gradient(135deg,#1a1f4a,#10162f);
    border-radius: 18px;
    padding: 18px;
    box-shadow: 0 0 20px rgba(0,0,0,0.4);
    border: 1px solid rgba(255,255,255,0.05);
}

.card:hover {
    transform: translateY(-2px);
    transition: 0.3s;
}

/* TITLES */
.title {
    font-size: 28px;
    font-weight: bold;
    color: #d9d9ff;
}

/* KPI */
.kpi-title {
    font-size: 14px;
    color: #bdbddd;
}

.kpi-value {
    font-size: 28px;
    font-weight: bold;
    color: white;
}

/* GRÁFICOS */
.chart-card {
    background: linear-gradient(135deg,#151932,#10162f);
    padding: 15px;
    border-radius: 18px;
    border: 1px solid rgba(255,255,255,0.05);
    box-shadow: 0 0 20px rgba(0,0,0,0.35);
}

/* SELECT */
div[data-baseweb="select"] {
    background-color: #10162f;
}

</style>
""", unsafe_allow_html=True)

# =========================================================
# SIDEBAR
# =========================================================
with st.sidebar:

    st.markdown("# 📊")
    st.markdown("## Dashboard")

    st.markdown("---")

    ano = st.selectbox(
        "Ano",
        ["2017", "2018", "2019"]
    )

    mes = st.selectbox(
        "Mês",
        [
            "Todos",
            "Janeiro",
            "Fevereiro",
            "Março",
            "Abril",
            "Maio"
        ]
    )

# =========================================================
# DADOS
# =========================================================
anos = [2017, 2018, 2019]

vendas = [67, 86, 19]

marcas = [
    "Adventure Works",
    "Proseware",
    "Wide World Importers",
    "Contoso",
    "Southridge Video",
    "Fabrikam",
    "Litware"
]

valores = [45, 37, 33, 25, 14, 10, 5]

continentes = ["Europa", "Ásia", "América Norte"]
continente_valores = [38, 34, 27]

# =========================================================
# HEADER
# =========================================================
st.markdown('<div class="title">ANÁLISE DE CHEFS</div>', unsafe_allow_html=True)

st.write("")

# =========================================================
# KPI CARDS
# =========================================================
c1, c2, c3, c4, c5 = st.columns(5)

def kpi_card(col, titulo, valor, cor):
    with col:
        st.markdown(f"""
        <div class="card">
            <div class="kpi-title">{titulo}</div>
            <div class="kpi-value" style="color:{cor}">
                {valor}
            </div>
        </div>
        """, unsafe_allow_html=True)

kpi_card(c1, "Total Vendido", "R$171 Mi", "#ffffff")
kpi_card(c2, "Total Lucro", "R$89 Mi", "#45d6ff")
kpi_card(c3, "% Margem", "52.01%", "#ff4fd8")
kpi_card(c4, "Notas Emitidas", "23.189", "#ffb84d")
kpi_card(c5, "Cobertura Clientes", "7.655", "#7dfc8a")

st.write("")

# =========================================================
# LINHA 1
# =========================================================
left, right = st.columns([2,1])

# =========================================================
# ÁREA
# =========================================================
with left:

    st.markdown('<div class="chart-card">', unsafe_allow_html=True)

    fig = go.Figure()

    fig.add_trace(go.Scatter(
        x=anos,
        y=vendas,
        fill='tozeroy',
        mode='lines+markers+text',
        text=[f"R${v} Mi" for v in vendas],
        textposition="top center",
        line=dict(color="#3f6cff", width=4),
        marker=dict(size=10, color="#ffffff")
    ))

    fig.update_layout(
        title="Total Vendido por Ano",
        paper_bgcolor="#151932",
        plot_bgcolor="#151932",
        font=dict(color="white"),
        height=400,
        xaxis=dict(showgrid=False),
        yaxis=dict(showgrid=True, gridcolor="rgba(255,255,255,0.08)")
    )

    st.plotly_chart(fig, use_container_width=True)

    st.markdown('</div>', unsafe_allow_html=True)

# =========================================================
# BARRAS HORIZONTAIS
# =========================================================
with right:

    st.markdown('<div class="chart-card">', unsafe_allow_html=True)

    fig2 = go.Figure(go.Bar(
        x=valores,
        y=marcas,
        orientation='h',
        marker=dict(
            color="#2f5bff"
        )
    ))

    fig2.update_layout(
        title="Total por Marca",
        paper_bgcolor="#151932",
        plot_bgcolor="#151932",
        font=dict(color="white"),
        height=400,
        yaxis=dict(autorange="reversed"),
        xaxis=dict(showgrid=False)
    )

    st.plotly_chart(fig2, use_container_width=True)

    st.markdown('</div>', unsafe_allow_html=True)

# =========================================================
# LINHA 2
# =========================================================
b1, b2 = st.columns([1,2])

# =========================================================
# DONUT
# =========================================================
with b1:

    st.markdown('<div class="chart-card">', unsafe_allow_html=True)

    fig3 = go.Figure(go.Pie(
        labels=continentes,
        values=continente_valores,
        hole=0.65,
        marker=dict(
            colors=["#4f7cff", "#7d5cff", "#c14dff"]
        )
    ))

    fig3.update_layout(
        title="Total por Continente",
        paper_bgcolor="#151932",
        font=dict(color="white"),
        height=350
    )

    st.plotly_chart(fig3, use_container_width=True)

    st.markdown('</div>', unsafe_allow_html=True)

# =========================================================
# MAPA
# =========================================================
with b2:

    st.markdown('<div class="chart-card">', unsafe_allow_html=True)

    mapa = pd.DataFrame({
        "pais": [
            "Brazil", "USA", "Canada", "Germany",
            "France", "Australia", "India"
        ],
        "lat": [-14.2, 37.1, 56.1, 51.1, 46.2, -25.2, 20.5],
        "lon": [-51.9, -95.7, -106.3, 10.4, 2.2, 133.7, 78.9],
        "vendas": [100, 200, 150, 120, 80, 60, 110]
    })

    fig4 = px.scatter_geo(
        mapa,
        lat="lat",
        lon="lon",
        size="vendas",
        hover_name="pais",
        projection="natural earth",
        color="vendas",
        color_continuous_scale="blues"
    )

    fig4.update_layout(
        title="Total por País e Continente",
        paper_bgcolor="#151932",
        font=dict(color="white"),
        geo=dict(
            bgcolor="#151932",
            showland=True,
            landcolor="#0f132b",
            showcountries=True,
            countrycolor="rgba(255,255,255,0.2)"
        ),
        height=350
    )

    st.plotly_chart(fig4, use_container_width=True)

    st.markdown('</div>', unsafe_allow_html=True)
