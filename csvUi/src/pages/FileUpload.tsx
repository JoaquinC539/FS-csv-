import { Box, Button, Card, CardContent, CardHeader, Divider, FormControl, Grid, Typography, type SxProps } from "@mui/material";
import axios from "axios";
import { useRef, useState, type ChangeEvent, type FC } from "react";

const generalCardSX: SxProps = {

    width: '100%',
    border: '1px solid #ddd',
    borderRadius: '4px',
    boxShadow: 'none'
}
const FileUpload: FC<{}> = () => {
    const [file, setFile] = useState<File|null>(null);
    const [uploading, setUploading] = useState<boolean>(false);
    const [inputKey, setInputKey] = useState(Date.now());

    const handleFileChange=(e:ChangeEvent<HTMLInputElement>)=>{
        setFile(e.target?.files?.[0] || null)
    }
    const handleUpload=async ()=>{
        if(!file) return ;
        setUploading(true);
        const formData=new FormData();
        formData.append("file",file);
        try {
            const response=await axios.post("http://localhost:8080/api/csv",formData,{
                headers:{
                    "Content-Type":"multipart/form-data"
                }
            });
            console.log("Upload successful",response.data)
            setFile(null);
            
        } catch (error) {
            console.error("Error uplaoding ",error)
        }
        finally{
            setUploading(false);
            setInputKey(Date.now())

        }
    }
    return (
        <Box textAlign={'left'} sx={{ fontFamily: "Arial, sans-serif" }}>
            <Box display={'flex'} justifyContent={'center'} flexDirection={'column'} p={0}>
                <Card sx={generalCardSX}>
                    <CardContent>
                        <Grid container size={12} display={"flex"} width={"100%"} justifyContent={"center"}>
                            <Typography variant="h1" fontSize={28}>
                                Input file
                            </Typography>
                        </Grid>
                        <Divider />
                        <Grid container  >                            
                                <Grid size={{ xs: 12, md:6,lg: 4 }} >
                                    <Typography>File:</Typography>
                                    <Box>
                                        <input type="file" key={inputKey} onChange={handleFileChange}/>
                                    </Box>
                                </Grid>
                        </Grid>
                        <Divider sx={{margin:3}}/>
                        <Grid container>
                             <Grid size={{xs:12}}>
                                    <Button disabled={!file  || uploading} variant="contained" onClick={handleUpload}>
                                        {uploading ? 'Uploading...' : 'Upload'}
                                    </Button>
                                </Grid>
                        </Grid>
                    </CardContent>
                </Card>
            </Box>
        </Box>
    )
}
export default FileUpload