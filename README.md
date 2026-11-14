🚀 System Design & High-Performance Product API

Uma API RESTful desenvolvida com foco em arquitetura distribuída, alta disponibilidade, escalabilidade horizontal e resiliência. Mais do que um simples CRUD de produtos, este projeto demonstra na prática a implementação de padrões avançados de engenharia de software e infraestrutura moderna.

🏗️ Arquitetura e Padrões Implementados

O ecossistema foi desenhado para suportar altos volumes de tráfego, separando responsabilidades e evitando gargalos:

Load Balancing (Balanceamento de Carga): Múltiplas instâncias da aplicação Spring Boot rodando em paralelo e gerenciadas pelo Nginx, distribuindo as requisições de forma eficiente.

Database Replication (Master-Replica): Arquitetura de banco de dados PostgreSQL dividida entre nó principal (escritas) e réplica (leituras), otimizando a performance e a segurança dos dados.

Distributed Caching (Padrão Cache-Aside): Uso do Redis em memória para respostas ultrarrápidas em consultas frequentes, com invalidação automática (@CacheEvict) nas operações de escrita para garantir a consistência eventual dos dados.

Resiliência e Timeouts: Configuração de limites de tempo de conexão e leitura (spring.data.redis.timeout) para evitar bloqueios em cascata caso o serviço de cache apresente lentidão.

CI/CD Automatizado: Pipeline configurada via GitHub Actions para validação contínua de código, execução de testes automatizados e build de imagens Docker a cada push ou Pull Request.

🛠️ Stack Tecnológica

Linguagem & Framework: Java 21, Spring Boot 3

Cache Distribuído: Redis

Banco de Dados: PostgreSQL 15

Proxy Reverso & Load Balancer: Nginx

Containerização & Orquestração: Docker & Docker Compose

Documentação da API: SpringDoc OpenAPI (Swagger UI)

CI/CD: GitHub Actions

📂 Estrutura do Projeto

├── .github/
│   └── workflows/
│       └── ci-cd.yml        # Pipeline de Integração Contínua (Java 21, Maven, Docker)
├── backend/                 # Código-fonte da API Spring Boot e Dockerfile
├── nginx/                   # Configurações do Load Balancer / Proxy Reverso
├── docker-compose.yml       # Orquestração completa dos containers
└── README.md                # Documentação do projeto


🚀 Como Executar o Projeto Localmente

Pré-requisitos

Docker e Docker Compose instalados na máquina.

Passo a Passo

Clone o repositório:

git clone https://github.com/crrsj/system-design



Suba todo o ecossistema com Docker Compose:

docker compose up -d --build


Acesse a Documentação Interativa (Swagger UI):

Com os containers em execução, abra o navegador em:

http://localhost:8080/swagger-ui/index.html

(Caso esteja acessando diretamente pela porta mapeada no Nginx, utilize http://localhost/swagger-ui/index.html).

<img width="1920" height="1080" alt="sd" src="https://github.com/user-attachments/assets/4af55a18-a966-44b5-b3ea-f939f64e0e74" />
