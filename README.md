# 🌱 AgroConnect API

API para a plataforma **AgroConnect**, que promove a conexão entre **produtores rurais** e **consumidores finais**, facilitando a comercialização de produtos agrícolas de forma segura e eficiente.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Bean Validation**
- **Banco de Dados H2 (para desenvolvimento)**
- **Lombok**
- **DevTools**
- **JUnit e Spring Security Test**

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── com.viniciushoffmanndev.agroconnectapi
     │       ├── controller/
     │       ├── service/
     │       ├── repository/
     │       └── model/
     └── resources/
         ├── application.properties
         └── static/
```

> ✅ O projeto segue boas práticas de separação por camadas (MVC + Service + Repository).

---

## ⚙️ Como Executar

### Pré-requisitos
- Java 17
- Maven

### Passos

```bash
# Clone o repositório
git clone https://github.com/viniciushoffmanndev/agroconnect-api.git
cd agroconnect-api

# Compile e execute
./mvnw spring-boot:run
```

> Acesse o console H2 em: `http://localhost:8080/h2-console`

---

## 🛡️ Autenticação

A segurança da API é baseada em **JWT**, com endpoints públicos e protegidos. O token é gerado após o login e deve ser enviado no header `Authorization` como:

```
Authorization: Bearer <seu_token_jwt>
```

---

## 📚 Documentação da API

*Em breve integração com Swagger/OpenAPI.*

---

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

---

## 🧾 Licença

Este projeto está licenciado sob a Licença MIT. Veja abaixo:

```
MIT License

Copyright (c) 2025 Vinicius Hoffmann

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell      
copies of the Software, and to permit persons to whom the Software is         
furnished to do so, subject to the following conditions:                       

The above copyright notice and this permission notice shall be included in    
all copies or substantial portions of the Software.                           

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR    
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,      
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE   
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER        
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN     
THE SOFTWARE.
```

---

## 👨‍💻 Autor

**Vinicius Hoffmann**  
[GitHub](https://github.com/viniciushoffmanndev) | [LinkedIn](https://www.linkedin.com/in/viniciushoffmanndev)

---