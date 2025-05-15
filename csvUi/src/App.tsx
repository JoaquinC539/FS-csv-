import { useState } from 'react'

import './App.css'
import { Box, createTheme, ThemeProvider } from '@mui/material'
import FileUpload from './pages/FileUpload'

const theme=createTheme({
   typography: {
    fontFamily: "Arial, sans-serif",
  }
})

function App() {
  const [count, setCount] = useState(0)


  return (
    <ThemeProvider theme={theme}>
    <Box>
      <FileUpload />
    </Box>
   </ThemeProvider>
  )
}

export default App
