/**
 * Clase utilizada para almacenar datos en el exploradovalidaNUMr, esto puede ser reimplementado para sessionstorage
 * websql, etc...
 */
export class SessionStorage {

  constructor() {
  }

  static getItem(key: string): any {
    return window.sessionStorage.getItem(key);
  }

  static setItem(key: string, value: any) {
    window.sessionStorage.setItem(key, value);
  }

  static clearStorage() {
    window.sessionStorage.clear();
  }

  static removeItem(key: string) {
    window.sessionStorage.removeItem(key);
  }

  static existItem(key: string) {
    return window.sessionStorage.getItem(key) !== undefined;
  }
}