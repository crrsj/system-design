package br.com.design.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão de Produtos - System Design & High Performance")
                        .version("1.0.0")
                        .description("""
                                ## 🚀 Visão Geral da Arquitetura
                                Esta API foi desenhada com foco em **alta escalabilidade, resiliência e performance.**
                                
                                ### 🛠️ Pilha Tecnológica Principal
                                * **Linguagem & Framework:** Java 21 & Spring Boot
                                * **Persistência & Dados:** PostgreSQL (Arquitetura Master-Replica para separar leituras e escritas)
                                * **Cache Distribuído:** Redis (Implementação do padrão **Cache-Aside** para consultas ultra-rápidas)
                                * **Orquestração & Infraestrutura:** Docker & Docker Compose (Múltiplas instâncias de API balanceadas por Nginx)
                                
                                ### 🏗️ Padrões Arquiteturais Implementados
                                * **Cache-Aside com Redis:** Otimização de leitura em memória com invalidação automática de cache (`@CacheEvict`) em operações de escrita no Master, garantindo consistência de dados.
                                * **Timeouts de Resiliência:** Proteção contra falhas de rede e indisponibilidade do cache (`spring.data.redis.timeout`).
                                * **Balanceamento de Carga:** Distribuição inteligente de requisições entre instâncias escaladas da API através do Nginx.
                                * **CI/CD Automatizado:** Pipeline de integração contínua configurada via GitHub Actions (Java 21, Maven e validação de containers).
                                """)
                        .contact(new Contact()
                                .name("Equipa de Arquitetura e Engenharia")
                                .email("suporte@sistema.local"))
                        .license(new License()
                                .name("Termos de Uso Interno")
                                .url("https://github.com/seu-repositorio")));
    }
}
