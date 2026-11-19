# 🪐 Space API — Gestion de Planètes (Spring Boot)

API REST développée avec **Spring Boot**, **PostgreSQL** et **Docker** permettant de gérer un catalogue de planètes (opérations CRUD complètes).

---

## 🛠️ Stack technique

- **Langage :** Java 21
- **Framework :** Spring Boot 4 (Spring Web, Spring Data JPA)
- **Base de données :** PostgreSQL 16 (conteneurisée via Docker)
- **Outil de build :** Maven
- **Tests API :** Collection Bruno incluse (`Space API/`)

---

## 🏗️ Architecture du projet

Le projet suit une architecture en couches (MVC / N-Tiers) :

```text
src/main/java/com/basespringboot/
├── controller/   # Exposition des endpoints REST (/planets)
├── dto/          # Objets de transfert de données (PlanetDto)
├── entity/       # Entités JPA mappées en base (Planet)
├── repository/   # Accès aux données via Spring Data JPA
└── service/      # Logique métier (Interface + Implémentation)
```

---

## 🚀 Lancer le projet en local

### 1. Prérequis
- **Java 21** (OpenJDK)
- **Docker** & **Docker Compose**
- **Bruno** (pour exécuter la collection de tests)

### 2. Démarrer la base de données PostgreSQL
À la racine du projet, lancez le conteneur Docker :
```bash
docker compose up -d
```
La base `base_db` est exposée sur le port **`5433`**.

### 3. Démarrer l'application Spring Boot
```bash
./mvnw spring-boot:run
```
L'API démarre sur **`http://localhost:8086`**.

---

## 📡 Endpoints disponibles (`/planets`)

| Méthode | Endpoint | Description | Code retour |
| :--- | :--- | :--- | :--- |
| **`POST`** | `/planets` | Créer une nouvelle planète | `201 Created` |
| **`GET`** | `/planets` | Récupérer toutes les planètes | `200 OK` |
| **`GET`** | `/planets/{id}` | Récupérer une planète par son ID | `200 OK` / `404` |
| **`PUT`** | `/planets/{id}` | Mettre à jour une planète existante | `200 OK` / `404` |
| **`DELETE`** | `/planets/{id}` | Supprimer une planète | `204 No Content` |

### Exemple de payload JSON (`POST` / `PUT`)
```json
{
  "name": "Mars",
  "distanceFromSun": 227.9,
  "type": "Tellurique"
}
```

---

## 🧪 Tester l'API avec Bruno

1. Ouvrez **Bruno**.
2. Cliquez sur **Open Collection** et sélectionnez le dossier `Space API/` présent à la racine du dépôt.
3. Exécutez les requêtes préconfigurées (`Create planet`, `Get all planets`, `Get planet by id`, `Update planet`, `Delete planet`).

---

## 🗺️ Feuille de route (Sprints)

- [x] **Sprint 1 :** Mise en place de l'architecture Spring Boot, PostgreSQL (Docker), CRUD `Planet` et collection Bruno.
- [ ] **Sprint 2 :** Sécurisation des endpoints via authentification **Bearer Token (JWT)**.
- [ ] **Sprint 3 :** Tests unitaires (JUnit 5 / Mockito) et tests de charge.
- [ ] **Sprint 4 :** Intégration d'une API externe gratuite (données astronomiques).