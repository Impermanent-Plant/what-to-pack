export class CityDTO {
  name: string
  country: string
  lat: number
  long: number
  constructor (name: string, country: string, lat: number, long: number) {
    this.name = name
    this.country = country
    this.lat = lat
    this.long = long
  }
}
