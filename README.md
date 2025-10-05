
# Roadside Assistance (Android, Kotlin + Compose)


Мобильное приложение‑MVP для помощи водителям: пользователь создаёт **заявку** (категория, описание, геолокация), ближайшие помощники откликаются; внутри — чат и трекинг приезда. Этот репозиторий — каркас с чистой архитектурой (MVVM + Repository) и демо‑экранами. Источник данных — In‑Memory (легко заменить на REST/Firebase).


## ✨ Возможности (MVP)
- Список заявок (реактивно через `Flow`).
- Создание заявки (категория, описание, координаты).
- Просмотр карточки заявки.
- Jetpack Navigation, Material 3, ViewModel.


## 🏗 Архитектура
- **UI:** Jetpack Compose + Navigation + Material 3.
- **State:** ViewModel + `StateFlow`.
- **Data:** `RequestRepository` с реализацией `InMemoryRequestRepository`.
- **Domain:** простые модели (`Request`, `Offer`, `User`, `ChatMessage`).


> Для реальных данных подключите Retrofit/Ktor или Firebase/Firestore. Контракты репозитория уже выделены.


## 🗺️ Навигация
- `list` → список заявок.
- `create` → форма создания.
- `detail/{id}` → карточка по ID.


## 🔌 Как заменить хранилище на реальное API
1. Создайте `RemoteRequestRepository : RequestRepository`.
2. Реализуйте методы через Retrofit/Ktor/Firebase.
3. Внедрите репозиторий в VM (через конструктор/Hilt).


## 🧪 Тестирование (предложения)
- Unit: бизнес‑логика в репозитории/VM (Junit4/Junit5).
- UI: Compose testing (semantics) для критичных сценариев.
- Интеграция: контрактные тесты для REST (если будет бэкенд).


## 📦 Сборка
- Android Studio **Hedgehog+** / AGP 8.5+ / Kotlin 2.0+.
- Запуск: `Run` в Android Studio.


## 📁 Структура
```
roadside-assistance/
├─ .gitignore

├─ README.md

├─ settings.gradle.kts

├─ build.gradle.kts

└─ app/

├─ build.gradle.kts

└─ src/

└─ main/

├─ AndroidManifest.xml

├─ kotlin/

│ └─ com/roadside/assistant/

│ ├─ RoadsideApp.kt

│ ├─ MainActivity.kt

│ ├─ NavGraph.kt

│ ├─ data/

│ │ ├─ model/

│ │ │ ├─ Request.kt

│ │ │ ├─ Offer.kt

│ │ │ ├─ User.kt

│ │ │ └─ ChatMessage.kt

│ │ ├─ RequestRepository.kt

│ │ └─ InMemoryRequestRepository.kt

│ ├─ feature/

│ │ ├─ list/RequestListScreen.kt

│ │ ├─ list/RequestListViewModel.kt

│ │ ├─ create/CreateRequestScreen.kt

│ │ ├─ create/CreateRequestViewModel.kt

│ │ ├─ detail/RequestDetailScreen.kt

│ │ └─ detail/RequestDetailViewModel.kt

│ └─ ui/theme/

│ ├─ Color.kt

│ ├─ Theme.kt

│ └─ Type.kt

└─ res/

├─ values/strings.xml

└─ mipmap-anydpi-v26/ic_launcher.xml
```

## 🗺️ Роадмап
- 🔜 Геолокация и карта (Google Maps + маркер заявки).
- 🔜 Чат по заявке (лист сообщений, отправка).
- 🔜 Пуш‑уведомления (FCM) с батч‑рассылкой и ретраями.
- 🔜 Матчмейкинг по радиусу/рейтингу (бэкенд/Functions).
- 🔜 Авторизация (телефон/почта) и роли (водитель/помощник).


## 📄 Лицензия
MIT
