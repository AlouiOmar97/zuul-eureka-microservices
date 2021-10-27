FROM node:14

WORKDIR /payment
COPY package.json .
RUN npm install
COPY . .
CMD npm start