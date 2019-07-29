/**
 * Clase utilizada para almacenar datos en el exploradovalidaNUMr, esto puede ser reimplementado para sessionstorage
 * websql, etc...
 */
export class LocalStorage {

    constructor() {
    }
  
    static getItem(key: string): any {
      return window.localStorage.getItem(key);
    }
  
    static setItem(key: string, value: any) {
      window.localStorage.setItem(key, value);
    }
  
    static clearStorage() {
      window.localStorage.clear();
    }
  
    static removeItem(key: string) {
      window.localStorage.removeItem(key);
    }
  }