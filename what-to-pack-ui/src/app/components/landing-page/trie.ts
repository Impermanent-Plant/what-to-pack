import { type CityDTO } from './city-obj'
export class TrieNode {
  isCompleteWord: boolean
  children: Map<string, TrieNode>
  completeMap: Map<string, CityDTO>

  constructor () {
    this.isCompleteWord = false
    this.children = new Map()
    this.completeMap = new Map()
  }
};
