# AI Prompt Different — Android App

This is an Android Studio project for the AI Prompt Different website.

## Build APK with one click using GitHub Actions

1. Create a GitHub repository.
2. Upload all files/folders from this project to the repository.
3. Open **Actions** → **Build APK** → **Run workflow**.
4. Wait for the build to finish.
5. Open the completed workflow run and download the artifact named **AI-Prompt-Different-debug-apk**.
6. Extract it and install `app-debug.apk` on your Android phone.

The workflow installs Android SDK/Gradle automatically, so Android Studio is not required for the GitHub build.

## Important security note
The bundled HTML currently contains client-side Firebase/ImgBB/admin credentials from the original website. Do not publish private credentials in a public repository. Move sensitive operations to a secure backend before making the repository public.
