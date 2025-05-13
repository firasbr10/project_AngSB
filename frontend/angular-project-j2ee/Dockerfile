# Étape 1 : Installation des dépendances
FROM node:20-alpine AS dependencies
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install -g @angular/cli@15.2.11 && \
    npm install --legacy-peer-deps

# Étape 2 : Build de l'application (en réutilisant les node_modules)
FROM dependencies AS builder
WORKDIR /app
COPY . .
RUN ng build --configuration=production

# Étape 3 : Serveur léger
FROM node:20-alpine
WORKDIR /app
COPY --from=builder /app/dist/angular-project-j2ee ./dist
RUN npm install -g http-server
EXPOSE 4200
CMD ["http-server", "dist", "-p", "4200", "--proxy", "http://host.docker.internal:9092?"]