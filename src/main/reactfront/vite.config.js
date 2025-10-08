import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: {
      // 백엔드 엔드포인트에 맞춰 경로 키를 잡으세요.
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
        secure: false,
      },
    },
  },
});
