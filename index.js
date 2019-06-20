"use strict";

import { NativeModules, Platform } from "react-native";

const Prompt = NativeModules.Prompt;

export class AndroidPrompt {
  export function devPrompt(message: string, defaultValue: string = ''): Promise<string> { {
    return Prompt.prompt(message, defaultValue);
  }

}
