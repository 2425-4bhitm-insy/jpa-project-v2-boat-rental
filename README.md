# Boat Rental Service

Welcome to our Boat Rental Service! Whether you're looking for a relaxing day on the water or an exciting adventure,
we have the perfect boat for you. Our rental service offers a variety of boats to suit your needs, whether it's for
fishing, sightseeing, or simply unwinding with family and friends. Enjoy the beauty of the water at your own pace with
our easy and hassle-free rental process.

# What We Offer
* Motorboats
* Sailboats
* Yacht

# Datenbank starten
*  docker run --restart unless-stopped --name boatRentalPostgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v $HOME/database/postgres:/var/lib/postgresql/data postgres
