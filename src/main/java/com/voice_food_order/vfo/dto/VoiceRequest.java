package com.voice_food_order.vfo.dto;

import lombok.Data;

@Data


    public class VoiceRequest {
        private String command;

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }
    }


