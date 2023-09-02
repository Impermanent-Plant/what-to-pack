/* eslint-disable @typescript-eslint/no-non-null-assertion */
/* eslint-disable @typescript-eslint/explicit-function-return-type */
/* eslint-disable @typescript-eslint/strict-boolean-expressions */
import { Component, type OnInit } from '@angular/core'
import { FormControl } from '@angular/forms'
import { type Observable } from 'rxjs'
import { map, startWith } from 'rxjs/operators'
import cities from 'cities.json'
import { TrieNode } from './trie'
@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.sass']
})

export class LandingPageComponent implements OnInit {
  myControl = new FormControl('')
  cities: any = cities
  options: string[] = []
  trie: TrieNode = new TrieNode()
  filteredOptions: Observable<string[]> | undefined
  jsonArray: any = []

  // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
  ngOnInit () {
    this.createTrie()
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value ?? ''))
    )
  }

  /**
   *
   * Searches through trie and adds matches to options list for meta-autocomplete component
   * @private
   * @param {string} value
   * @return {void}  {void}
   */
  private _filter (value: string): string[] {
    const MIN_INPUT_LENGTH = 3
    const MAX_OPTIONS_COUNT = 20

    if (value.length < MIN_INPUT_LENGTH) {
      this.options = []
      return this.options
    }

    const filterValue = value.toLowerCase()
    const queue: TrieNode[] = []
    this.options = []

    let currentNode = this.trie
    for (const char of filterValue) {
      currentNode = currentNode.children.get(char)!

      if (!currentNode) {
        return this.options
      }
    }

    if (currentNode.isCompleteWord) {
      for (const [, val] of currentNode.completeMap) {
        if (this.options.length >= MAX_OPTIONS_COUNT) {
          break
        }
        this.options.push(`${val.name}, ${val.country}`)
      }
    }

    queue.push(...currentNode.children.values())

    while (this.options.length < MAX_OPTIONS_COUNT && queue.length > 0) {
      const node = queue.shift()
      if (!node) {
        continue
      }

      if (node.isCompleteWord) {
        for (const [, val] of node.completeMap) {
          if (this.options.length >= MAX_OPTIONS_COUNT) {
            break
          }
          this.options.push(`${val.name}, ${val.country}`)
        }
      }

      queue.push(...node.children.values())
    }

    return this.options
  }

  /**
   * Creates the initial Trie of city and country from cities.json
   * @date 9/2/2023 - 3:14:49 PM
   */
  createTrie = () => {
    const cities = this.cities
    cities.forEach((cityDTO: any) => {
      let cityName = cityDTO.name.toLowerCase()
      cityName += ', ' + cityDTO.country.toLowerCase()
      let currentNode = this.trie

      for (let i = 0; i < cityName.length; i++) {
        const char = cityName[i]

        if (!currentNode.children.has(char)) {
          const newNode = new TrieNode()
          currentNode.children.set(char, newNode)
        }

        currentNode = currentNode.children.get(char)!

        if (i === cityName.length - 1) {
          currentNode.isCompleteWord = true
          currentNode.completeMap.set(cityName, cityDTO)
        }
      }
    })
  }
}
